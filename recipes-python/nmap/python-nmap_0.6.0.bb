DESCRIPTION = "nmap for python"
SUMMARY = "python-nmap is a python library which helps in using nmap port scanner. It allows to easilly manipulate nmap scan results and will be a perfect tool for systems administrators who want to automatize scanning task and reports. It also supports nmap script outputs."
HOMEPAGE = "http://xael.org/norman/python/python-nmap/"
SECTION = "devel/python"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://gpl-3.0.txt;md5=d32239bcb673463ab874e80d47fae504"

SRCNAME = "python-nmap"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "c3996b1e8dfb944fa30fb37d3fc43a67"
SRC_URI[sha256sum] = "233ee39da05aac3f0f22e480dcb0e9b1b707cac3518859aaa1a016f6f88bf250"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

RDEPENDS_${PN} = "python-xml"

BBCLASSEXTEND = "native"
