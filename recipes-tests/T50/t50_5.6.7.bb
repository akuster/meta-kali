DESCRIPTION = "Very fast network stress tool"
LICENSE = "GPLv2"
SECTION = "testing/security"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75859989545e37968a99b631ef42722e"

SRC_URI = "https://github.com/fredericopissarra/t50/archive/${PV}-fix1.tar.gz"

SRC_URI[md5sum] = "9b9b7f4e5faf26f772ff48c8fba6d8a0"
SRC_URI[sha256sum] = "869761b1060752d6fc9d7c90c79fe98348a643e1ae9da7def090302a8cc965ff"

inherit autotools-brokensep

S = "${WORKDIR}/t50-${PV}-fix1"
