require core-image-kali.bb

DESCRIPTION = "A Kali image that contains all packages"

KALI_IMAGE_TYPE = "Kali-full"

IMAGE_INSTALL += "\
    packagegroup-kali-base \
    packagegroup-kali-passwd \
    packagegroup-kali-testing \
    packagegroup-kali-forensic \
    ${@bb.utils.contains("DISTRO_FEATURES", "wifi", "packagegroup-kali-wireless", "", d)} \
    packagegroup-kali-scan \
    "
