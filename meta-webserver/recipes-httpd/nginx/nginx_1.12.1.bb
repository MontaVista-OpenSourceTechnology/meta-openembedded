require nginx.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=903753de5f86a1ee0341fd2f9491b282"

SRC_URI[md5sum] = "a307e74aca95403e5ee00f153807ce58"
SRC_URI[sha256sum] = "8793bf426485a30f91021b6b945a9fd8a84d87d17b566562c3797aba8fac76fb"

PR .= ".2"

SRC_URL += "file://CVE-2018-16845.patch"
SRC_URL += "file://0001-CVE-2018-16843-nginx-Excessive-memory-consumption-vi.patch"
SRC_URL += "file://0002-CVE-2018-16844-nginx-Excessive-CPU-usage-via-flaw-in.patch"
