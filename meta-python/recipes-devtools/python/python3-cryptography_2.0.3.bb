inherit pypi setuptools3
require python-cryptography.inc

PR .= ".1"

SRC_URI += " \
    file://run-ptest \
    file://CVE-2020-25659.patch \
    file://CVE-2023-23931.patch \
"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-lang \
"
