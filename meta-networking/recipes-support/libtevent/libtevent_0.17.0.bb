SUMMARY = "Hierarchical, reference counted memory pool system with destructors"
HOMEPAGE = "https://tevent.samba.org"
SECTION = "libs"
LICENSE = "LGPL-3.0-or-later"

DEPENDS += "libtalloc libtirpc cmocka"
RDEPENDS:python3-tevent = "python3"

export PYTHONHASHSEED = "1"
export PYTHONARCHDIR = "${PYTHON_SITEPACKAGES_DIR}"

SRC_URI = "https://samba.org/ftp/tevent/tevent-${PV}.tar.gz \
           file://0001-Add-configure-options-for-packages.patch \
           file://0002-Fix-pyext_PATTERN-for-cross-compilation.patch \
           file://run-ptest \
          "

LIC_FILES_CHKSUM = "file://tevent.h;endline=26;md5=47386b7c539bf2706b7ce52dc9341681"

SRC_URI[sha256sum] = "7702fb373b69da2960b86134b6a9ec6fa0b949a01756fec00a4a6a43575c8361"

inherit pkgconfig ptest waf-samba

PACKAGECONFIG ??= "\
    ${@bb.utils.filter('DISTRO_FEATURES', 'acl', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'xattr', 'attr', '', d)} \
"
PACKAGECONFIG[acl] = "--with-acl,--without-acl,acl"
PACKAGECONFIG[attr] = "--with-attr,--without-attr,attr"
PACKAGECONFIG[libbsd] = "--with-libbsd,--without-libbsd,libbsd"
PACKAGECONFIG[libcap] = "--with-libcap,--without-libcap,libcap"
PACKAGECONFIG[valgrind] = "--with-valgrind,--without-valgrind,valgrind"

SRC_URI += "${@bb.utils.contains('PACKAGECONFIG', 'attr', '', 'file://avoid-attr-unless-wanted.patch', d)}"

S = "${UNPACKDIR}/tevent-${PV}"

# Cross_compile cannot use preforked process, since fork process earlier than point subproces.popen
# to cross Popen
export WAF_NO_PREFORK = "yes"

EXTRA_OECONF += "--disable-rpath \
                 --disable-rpath-install \
                 --bundled-libraries=NONE \
                 --builtin-libraries=replace \
                 --with-libiconv=${STAGING_DIR_HOST}${prefix}\
                 --without-gettext \
                "

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    install -m 0755 ${B}/bin/test_tevent_* ${D}${PTEST_PATH}/tests/
    install -m 0755 ${B}/bin/replace_testsuite ${D}${PTEST_PATH}/tests/
}

PACKAGES += "python3-tevent"

RPROVIDES:${PN}-dbg += "python3-tevent-dbg"

FILES:python3-tevent = "${PYTHON_SITEPACKAGES_DIR}/*"

INSANE_SKIP:${MLPREFIX}python3-tevent = "dev-so"
