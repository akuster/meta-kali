DESCRIPTION = "A small image with Security testing packages"

IMAGE_FEATURES += "ssh-server-openssh"

KALI_IMAGE_TYPE = "Kali"

IMAGE_INSTALL = "\
    packagegroup-base \
    packagegroup-core-boot \
    packagegroup-kali-base \
    os-release \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "packagegroup-core-x11", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "packagegroup-xfce-base", "", d)} \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS ?= " "

LICENSE = "MIT"
inherit core-image

export IMAGE_BASENAME = "core-image-kali"

inherit core-image
