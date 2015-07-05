DESCRIPTION = "A library for network address representation and manipulation"
HOMEPAGE = "https://github.com/drkjam/netaddr"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b277425f87f3b06d25af45d8b96f9682"

SRCNAME = "netaddr"

SRC_URI = "https://pypi.python.org/packages/source/n/${SRCNAME}/${SRCNAME}-${PV}.zip"

SRC_URI[md5sum] = "4aecd1ce80ddf242953f2a196046a14a"
SRC_URI[sha256sum] = "6d19b06b9bb6c9562b5f67ec36511946cfcfebf024a0c804b6fd5c36d3b11fb6"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
