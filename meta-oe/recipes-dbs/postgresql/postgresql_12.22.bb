require postgresql.inc

LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=89afbb2d7716371015101c2b2cb4297a"

PR .= "4"

SRC_URI += "\
   file://not-check-libperl.patch \
   file://0001-Add-support-for-RISC-V.patch \
   file://0001-Improve-reproducibility.patch \
   file://CVE-2025-12817.patch \
   file://CVE-2025-1094-01.patch \
   file://CVE-2025-1094-02.patch \
   file://CVE-2025-1094-03.patch \
   file://CVE-2025-1094-04.patch \
   file://CVE-2025-1094-05.patch \
   file://CVE-2025-1094-06.patch \
   file://CVE-2025-1094-07.patch \
   file://CVE-2025-1094-08.patch \
   file://CVE-2025-1094-09.patch \
   file://CVE-2025-1094-10.patch \
   file://CVE-2025-1094-11.patch \
   file://CVE-2025-1094-12.patch \
   file://CVE-2025-4207.patch \
   file://CVE-2025-12818.patch \
   file://CVE-2026-2004-001.patch \
   file://CVE-2026-2004-002.patch \
   file://CVE-2026-2004-003.patch \
   file://CVE-2026-2005.patch \
   file://CVE-2026-2006-001.patch \
   file://CVE-2026-2006-002.patch \
   file://CVE-2026-2006-003.patch \
   file://CVE-2026-2006-004.patch \
   file://CVE-2026-2006-005.patch \
   file://CVE-2026-2006-006.patch \
"

SRC_URI[sha256sum] = "8df3c0474782589d3c6f374b5133b1bd14d168086edbc13c6e72e67dd4527a3b"
