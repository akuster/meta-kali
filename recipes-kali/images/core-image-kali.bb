DESCRIPTION = "A small image with Security testing packages"

IMAGE_FEATURES += "ssh-server-openssh"

KALI_IMAGE_TYPE = "Kali"

IMAGE_INSTALL = "\
    packagegroup-base \
    packagegroup-core-x11 \
    packagegroup-xfce-base \
    packagegroup-kali-base \
    os-release \
    "

REQUIRED_DISTRO_FEATURES = "x11"

IMAGE_LINGUAS ?= " "

LICENSE = "MIT"

export IMAGE_BASENAME = "core-image-kali"

inherit core-image
