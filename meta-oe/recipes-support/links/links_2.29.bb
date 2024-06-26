require links.inc

DEPENDS += "gpm"
RCONFLICTS:${PN} = "links-x11"

EXTRA_OECONF = "--enable-graphics \
                --with-ssl=${STAGING_LIBDIR}/.. --with-libjpeg \
                --without-libtiff --without-svgalib --with-fb \
                --without-directfb --without-pmshell --without-atheos \
                --without-x"
SRC_URI[sha256sum] = "22aa96c0b38e1a6f8f7ed9d7a4167a47fc37246097759ef6059ecf8f9ead7998"

CVE_STATUS[CVE-2008-3319] = "cpe-incorrect: The recipe used in the `meta-openembedded` is a different links package compared to the one which has the CVE issue."
