DESCRIPTION = "Art of Memory Forensics"
SUMMARY = "The Volatility Framework is open source and written in Python"
SECTION = "forensics/security"
HOMEPAGE = "http://www.volatilityfoundation.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d3bef845c1a28f9e71ac0ad63e4b5a47"

SRC_URI = "http://downloads.volatilityfoundation.org/releases/${PV}/${BP}.tar.gz"

SRC_URI[md5sum] = "4f9ad730fb2174c90182cc29cb249d20"
SRC_URI[sha256sum] = "684fdffd79ca4453298ee2eb001137cff802bc4b3dfaaa38c4335321f7cccef1"

inherit autotools-brokensep setuptools

FILES_${PN} += "${datadir}/contrib/plugins ${datadir}/tools"
