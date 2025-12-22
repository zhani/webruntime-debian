inherit image

DESCRIPTION = "Ladybird Webruntime Image"

IMAGE_PREINSTALL += " \
    bash \
    bash-completion \
    ca-certificates \
    console-setup \
    iproute2 \
    iputils-ping \
    keyboard-configuration \
    libpam-systemd \
    lshw \
    lsb-release \
    mesa-vulkan-drivers \
    ntpsec \
    openssh-server \
    plymouth \
    plymouth-themes \
    polkitd \
    pulseaudio \
    sudo \
    systemd \
    systemd-resolved \
    vim \
    weston"

IMAGE_INSTALL += " \
    customization \
    customization-ladybird \
    expand-on-first-boot \
    sshd-regen-keys \
    weston-init \
    weston-webruntime-modules \
    ladybird"

