SUMMARY = "dav1d AV1 decoder"
DESCRIPTION = "Targeted to be small, portable and fast."
HOMEPAGE = "https://code.videolan.org/videolan/dav1d"
SECTION = "multimedia"
LICENSE = "BSD-2-Clause"

LIC_FILES_CHKSUM = "file://COPYING;md5=c8055cfe7548dfdaa3a6dc45d8793669"

SRC_URI = "git://code.videolan.org/videolan/dav1d.git;protocol=https;nobranch=1"
SRCREV = "42b2b24fb8819f1ed3643aa9cf2a62f03868e3aa"


DEPENDS:append:x86 = " nasm-native"
DEPENDS:append:x86-64 = " nasm-native"

inherit meson pkgconfig

# RVV assembler routines are not yet available for RISCV32
EXTRA_OEMESON:append:riscv32 = " -Denable_asm=false"
