inherit pypi setuptools
require python-cryptography.inc

PR .= ".2"

SRC_URI += " \
    file://run-ptest \
    file://CVE-2020-25659.patch \
    file://CVE-2023-23931.patch \
"

DEPENDS += " \
    ${PYTHON_PN}-enum34 \
"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-enum34 \
    ${PYTHON_PN}-ipaddress \
"

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-enum34 \
    ${PYTHON_PN}-ipaddress \
    ${PYTHON_PN}-contextlib \
"
