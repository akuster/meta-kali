DESCRIPTION ="A command line tool used to flood any device that is processing RTP."
HOMEPAGE = "http://www.hackingvoip.com/sec_tools.html"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE_SOFTWARE;md5=0be67017f1c770313ad7b40e18d568f1"

SRC_URI = "http://www.hackingvoip.com/tools/rtpflood.tar.gz"

SRC_URI[md5sum] = "3e8491d113e668a4ec055355d7330def"
SRC_URI[sha256sum] = "bdfc578b09ba6923e7e765b29c27e10bafb5a81c30defe442bf690de5623cce3"

S = "${WORKDIR}/${PN}"

do_configure () {
    sed -i 's/gcc/\$(CC)/' ${S}/Makefile
}

do_compile () {
    make CC="${CC}"
}

do_install () {
    install -d ${D}/${sbindir}

    install -m 755 ${B}/rtpflood ${D}/${sbindir}
}
