SUMMARY = "A client-side C library implementing the SSH2 protocol"
HOMEPAGE = "http://www.libssh2.org/"
SECTION = "libs"

DEPENDS = "zlib"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=c5cf34fc0acb44b082ef50ef5e4354ca"

PR .= ".2"

SRC_URI = "http://www.libssh2.org/download/${BP}.tar.gz \
           file://CVE-2019-17498.patch \
           file://CVE-2019-3855.patch \
           file://CVE-2019-3856.patch \
           file://CVE-2019-3857.patch \
           file://CVE-2019-3858.patch \
           file://CVE-2019-3859-1.patch \
           file://CVE-2019-3859-2.patch \
           file://CVE-2019-3860.patch \
           file://CVE-2019-3861.patch \
           file://CVE-2019-3862.patch \
           file://CVE-2019-3863.patch \
           file://CVE-2020-22218.patch \
          "
SRC_URI[md5sum] = "3d1147cae66e2959ea5441b183de1b1c"
SRC_URI[sha256sum] = "39f34e2f6835f4b992cafe8625073a88e5a28ba78f83e8099610a7b3af4676d4"

inherit autotools pkgconfig

EXTRA_OECONF += "\
                 --with-libz \
                 --with-libz-prefix=${STAGING_LIBDIR} \
                "

# only one of openssl and gcrypt could be set
PACKAGECONFIG ??= "openssl"
PACKAGECONFIG[openssl] = "--with-openssl --with-libssl-prefix=${STAGING_LIBDIR},--without-openssl,openssl"
PACKAGECONFIG[gcrypt] = "--with-libgcrypt --with-libgcrypt-prefix=${STAGING_EXECPREFIXDIR},--without-libgcrypt,libgcrypt"

BBCLASSEXTEND = "native"
