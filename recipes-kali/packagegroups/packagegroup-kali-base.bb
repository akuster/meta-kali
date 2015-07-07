DESCRIPTION = "Security packagegroup for Poky"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PACKAGES = "\
    ${PN} \
    "

RDEPENDS_${PN} = "\
    apache2 \
    atftpd \
    axel \
    expect \
    git \
    iw \
    lvm2 \
    netcat \
    openssh-sshd \
    openvpn \
    p7zip \
    parted \
    php \
    rfkill \
    samba \
    screen \
    net-snmp-server-snmpd \
    net-snmp \
    subversion \
    sudo \
    tcpdump \
    tmux \
    testdisk \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "packagegroup-kali-base-xfce", "", d)} \
"

RDEPENDS_${PN}-xcfe = "\
    gparted \
    florence \
"
