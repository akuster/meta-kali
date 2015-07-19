SUMMARY ="A IP and URL analysis tool"
DESCRIPTION = "Automater is a URL/Domain, IP Address, and Md5 Hash OSINT tool aimed at making the analysis process easier for intrusion Analysts. Given a target (URL, IP, or HASH) or a file full of targets Automater will return relevant results from sources like the following: IPvoid.com, Robtex.com, Fortiguard.com, unshorten.me, Urlvoid.com, Labs.alienvault.com, ThreatExpert, VxVault, and VirusTotal."
HOMEPAGE = "http://www.tekdefense.com/automater/"
SECTION = "Testing"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=12345"

SRCREV = "5f57a9f6092122188995c93718de643a5aa4dc54"

PV = "0.21+git${SRCPV}"

SRC_URI = "git://github.com/1aN0rmus/TekDefense-Automater.git"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d ${D}/${docdir}/${BPN}
    install -d ${D}/${datadir}/${BPN}

    install -m 644 docs/* ${D}/${docdir}/${BPN}
    install -m 644 LICENSE ${D}/${docdir}/${BPN}
    install -m 644 README.md ${D}/${docdir}/${BPN}
    install -m 755 *.py  ${D}/${datadir}/${BPN}
    install -m 755 *.xml  ${D}/${datadir}/${BPN}
}

RDEPENDS_${PN} = "python-core python-netclient python-xml python-argparse python-html python-re "
