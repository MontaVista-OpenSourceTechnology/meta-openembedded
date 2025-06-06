SUMMARY = "MCPP is a portable C/C++ preprocessor"
HOMEPAGE = "http://mcpp.sourceforge.net/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5ca370b75ec890321888a00cea9bc1d5"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz \
           file://ice-mcpp.patch \
           file://0001-configure-Fix-checks-for-system-headers.patch \
           file://CVE-2019-14274.patch"
SRC_URI[sha256sum] = "3b9b4421888519876c4fc68ade324a3bbd81ceeb7092ecdbbc2055099fcb8864"

UPSTREAM_CHECK_URI = "https://sourceforge.net/projects/mcpp/files/mcpp/"
UPSTREAM_CHECK_REGEX = "${BPN}/V\.(?P<pver>\d+(\.\d+)+)"

inherit autotools

EXTRA_OECONF = " --enable-mcpplib "

BBCLASSEXTEND = "native nativesdk"

# http://errors.yoctoproject.org/Errors/Details/766883/
# mcpp-2.7.2/src/expand.c:713:21: error: assignment to 'char *' from incompatible pointer type 'LOCATION *' {aka 'struct location *'} [-Wincompatible-pointer-types]
CFLAGS += "-Wno-error=incompatible-pointer-types"

# http://errors.yoctoproject.org/Errors/Details/850149/
# ../../mcpp-2.7.2/src/system.c:3436:15: error: expected identifier or '*' before 'true'
CFLAGS += "-std=gnu17"
