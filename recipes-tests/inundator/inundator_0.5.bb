DESCRIPTION = "inundator is a tool used to anonymously inundate intrusion detection logs with false positives to obfuscate a real attack, leaving the IDS analyst feeling completely inundated."

HOMEPAGE = "http://inundator.sourceforge.net/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://inundator.pl;md5=8e9c76d54ffa9e1f4e916384d693fd7d"

SRC_URI = "http://sourceforge.net/projects/${PN}/files/${PV}/${PN}_${PV}.tar.gz"

SRC_URI[md5sum] = "fca82b19eff4e286e6706f844d359125"
SRC_URI[sha256sum] = "fd032179cf97cf5cc59b084289cd797e7f26a9e6146138286808d4eabbe8abb9"

inherit autotools-brokensep

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    make DESTDIR=${D} 
}

RDEPENDS_${PN} = "nmap perl"
