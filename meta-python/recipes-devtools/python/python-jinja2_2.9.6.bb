inherit pypi setuptools
require python-jinja2.inc

PR .= ".1"

SRC_URI += " \
    file://CVE-2024-22195.patch \
"
