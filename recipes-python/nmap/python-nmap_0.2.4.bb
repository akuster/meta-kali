DESCRIPTION = "nmap for python"
SUMMARY = "python-nmap is a python library which helps in using nmap port scanner. It allows to easilly manipulate nmap scan results and will be a perfect tool for systems administrators who want to automatize scanning task and reports. It also supports nmap script outputs."
HOMEPAGE = "http://xael.org/norman/python/python-nmap/"
SECTION = "devel/python"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://gpl-3.0.txt;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://xael.org/norman/python/${PN}/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "f23ba911dc9cd8018c961c7e66bfc68d"
SRC_URI[sha256sum] = "160c562b81c8f41c96f84ead8cf736123ab7bb908bb47269d2c5d77a6503d84d"

S = "${WORKDIR}/${PN}-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-xml"

BBCLASSEXTEND = "native"
