require dnsmasq.inc

PR .= ".7"

SRC_URI += "\
    file://lua.patch \
    file://CVE-2019-14834.patch \
    file://CVE-2020-25681-dep1.patch \
    file://CVE-2020-25681-25682-25683-25687.patch \
    file://0001-CVE-2020-25685_1.patch \
    file://0001-CVE-2020-25685_2.patch \
    file://0001-CVE-2020-25686_p1.patch \
    file://0001-CVE-2020-25686_p2.patch \
    file://0001-CVE-2021-3448.patch \
    file://0001-CVE-2022-0934.patch \
    file://CVE-2023-28450.patch \
"

SRC_URI[dnsmasq-2.78.md5sum] = "3bb97f264c73853f802bf70610150788"
SRC_URI[dnsmasq-2.78.sha256sum] = "c92e5d78aa6353354d02aabf74590d08980bb1385d8a00b80ef9bc80430aa1dc"
