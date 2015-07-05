DESCRIPTION = "The information gathering suite"
SUMMARY = "theHarvester is a tool for gathering e-mail accounts, subdomain names, virtual hosts, open ports/ banners, and employee names from different public sources (search engines, pgp key servers)."
HOMEPAGE = "http://www.edge-security.com/theharvester.php"
SECTION = "scan/security"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSES;md5=a07dde533a3850aa16e089ad0bf743fd"

SRCREV = "4552322fedc9a4a8d08375b5f245150efc993cd3"
SRC_URI = "git://github.com/laramies/theHarvester.git"

S = "${WORKDIR}/git"

inherit autotools-brokensep

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d ${D}/opt/${PN}
    tar --exclude=.git --exclude=.gitignore -cvf - . | (cd ${D}/opt/${PN}  && tar xvf - )
}

PACKAGE = "${PN}"

FILES_${PN} = "/opt/${PN}"

RDEPENDS_${PN} = "python python-netclient"
