SUMMARY = "A module wrapper for os.path"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=141643e11c48898150daa83802dbc65f"

SRC_URI[sha256sum] = "d41e05ed4fa1d4f6d702df3c1e0a1a255d7b544287432456455dc7c51e5f98e9"

SRC_URI += "\
    file://run-ptest \
"

inherit pypi python_setuptools_build_meta ptest

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    python3-appdirs \
    python3-crypt \
    python3-io \
    python3-numbers \
    python3-shell \
"
RDEPENDS:${PN}-ptest += " \
    python3-pytest \
    python3-unittest-automake-output \
"

BBCLASSEXTEND = "nativesdk native"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/test
    cp -rf ${S}/tests/test_* ${D}${PTEST_PATH}/test/
    install -d ${D}${PTEST_PATH}/path
    cp -rf ${S}/path/* ${D}${PTEST_PATH}/path/
}
