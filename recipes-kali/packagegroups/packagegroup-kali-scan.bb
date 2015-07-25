DESCRIPTION = "Kali Scanner group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PACKAGES = "\
    ${PN} \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "packagegroup-kali-scan-xfce", "", d)} \
        "

RDEPENDS_${PN} = "\
    braa \
    nmap \
    dnsrecon \
    goofile \
    p0f \
    p0f-tools \
    theHarvester \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "packagegroup-kali-scan-xfce", "", d)} \
"
RDEPENDS_packagegroup-kali-scan-xfce = "\
    discover \
    xdotool \
"

