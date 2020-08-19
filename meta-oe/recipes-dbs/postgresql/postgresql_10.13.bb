require postgresql.inc

LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=fc4ce21960f0c561460d750bc270d11f"

SRC_URI += "\
    file://not-check-libperl.patch \
"

SRC_URI[md5sum] = "db1d4a6f886e3bb5d8ae92d611313a6c"
SRC_URI[sha256sum] = "4d701f450cd92ffb123cf6c296e9656abbc2ab7ea6507894ff1e2475ae0754e1"
