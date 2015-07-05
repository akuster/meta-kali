DESCRIPTION = "DHCP exhaustin script"
SUMMARY = "DHCPig initiates an advanced DHCP exhaustion attack. It will consume all IPs on the LAN, stop new users from obtaining IPs, release any IPs in use, then for good measure send gratuitous ARP and knock all windows hosts offline."

LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://pig.py;md5=9c98cd302dd793603bc2e1dac4a28f3e"

SRCREV = "cc4109ae1aab895d09913b0cf7a50673a26c37dc"
SRC_URI = "git://github.com/kamorin/DHCPig.git"

S = "${WORKDIR}/git"

PACKAGE = "${PN}"

do_install () {
    install -d ${D}/${sbindir}
    install -m 755 ${S}/pig.py ${D}/${sbindir}
}

RDEPENDS_${PN} = "python scapy"
