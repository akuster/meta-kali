DESCRIPTION ="A UDP iax test tool"
SUMMARY = "A UDP Inter-Asterisk_eXchange (i.e. IAX) packet was captured from an IAX channel between two Asterisk IP PBX’s. The content of that packet is the source of the payload for the attack embodied by this tool. While the IAX protocol header might not match the Asterisk PBX you’ll attack with this tool, it may require more processing on the part of the PBX than a simple udpflood without any payload that even resembles an IAX payload."
HOMEPAGE = "http://www.hackingvoip.com/sec_tools.html"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE_SOFTWARE;md5=0be67017f1c770313ad7b40e18d568f1"

SRC_URI = "http://www.hackingvoip.com/tools/iaxflood.tar.gz"

SRC_URI[md5sum] = "39d557dcfdcab7c668ba321f4de82664"
SRC_URI[sha256sum] = "2191d8e808052a44bb250c9275df25e9d54c6b592193c072af58631ed6903e81"

S = "${WORKDIR}/${PN}"

do_configure () {
    sed -i 's/gcc/\$(CC)/' ${S}/makefile
}

do_compile () {
    make CC="${CC}"
}

do_install () {
    install -d ${D}/${sbindir}

    install -m 755 ${B}/iaxflood ${D}/${sbindir}
}
