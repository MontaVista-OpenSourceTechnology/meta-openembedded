require postgresql.inc

LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=89afbb2d7716371015101c2b2cb4297a"

SRC_URI += "\
   file://not-check-libperl.patch \
   file://0001-Add-support-for-RISC-V.patch \
   file://0001-Improve-reproducibility.patch \
"

SRC_URI[sha256sum] = "2d543af3009fec7fd5af35f7a70c95085d3eef6b508e517aa9493e99b15e9ea9"
