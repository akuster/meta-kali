DESCRIPTION = "A small image with Security testing packages"

IMAGE_FEATURES += "ssh-server-openssh"

KALI_IMAGE_TYPE = "Kali"

IMAGE_INSTALL = "\
    packagegroup-base \
    packagegroup-kali-base \
    os-release \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "packagegroup-core-x11", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "packagegroup-xfce-base", "", d)} \
    "

IMAGE_LINGUAS ?= " "

LICENSE = "MIT"

export IMAGE_BASENAME = "core-image-kali"

inherit core-image
