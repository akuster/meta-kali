require core-image-kali.bb

DESCRIPTION = "A Kali image with testing packages"

KALI_IMAGE_TYPE = "Kali-testing"

IMAGE_INSTALL += "\
    packagegroup-kali-base \
    packagegroup-kali-testing \
    "
