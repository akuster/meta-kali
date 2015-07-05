DESCRIPTION = "A Powerfule DNS enumeration script"
HOMEPAGE = "ttps://github.com/darkoperator/dnsrecon"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://dnsrecon.py;startline=9;endline=10;md5=1234"

SRCREV = "62e644e798c2807f36a67eeb67691903a7526850"
SRC_URI = "git://github.com/darkoperator/dnsrecon.git"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d ${D}/opt/${PN}
    tar --exclude=.git --exclude=.gitignore -cvf - . | (cd ${D}/opt/${PN}  && tar xvf - )
}

PACKAGE = "${PN}"

FILES_${PN} = "/opt/${PN}"

RDEPENDS_${PN} = "python-dnspython  python-netaddr"
