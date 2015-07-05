DESCRIPTION = "For use with Kali Linux. Custom bash scripts used to automate various pentesting tasks."
HOMEPAGE = "https://github.com/leebaird/discover.git"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://discover.sh;md5=1234"

SRCREV = "50c773aac66ef02b7ce1b7d494d601d6b24e1d4d"
SRC_URI = "git://github.com/leebaird/discover.git"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d ${D}/opt/${PN}
    tar --exclude=.git --exclude=.gitignore -cvf - . | (cd ${D}/opt/${PN}  && tar xvf - )
}

PACKAGE = "${PN}"

FILES_${PN} = "/opt/${PN}"

RDEPENDS_${PN} = "xdotool goofile theHarvester nmap dnsrecon perl bash"
