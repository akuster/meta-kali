DESCRIPTION = "Kali PassWord group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PACKAGES = "\
    ${PN} \
        "

RDEPENDS_${PN} = "\
    crunch \
    ncrack\
    pwgen \
    john \
"
