require nginx.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=3691402cc54ce09f800ca348634a2dfe"

SRC_URI[md5sum] = "d063f746d3dc4298aed9c518f1684166"
SRC_URI[sha256sum] = "eeba09aecfbe8277ac33a5a2486ec2d6731739f3c1c701b42a0c3784af67ad90"

SRC_URI += "file://CVE-2019-20372.patch \
	    file://CVE-2019-9511.patch \
	    file://CVE-2019-9516.patch \
	   "
