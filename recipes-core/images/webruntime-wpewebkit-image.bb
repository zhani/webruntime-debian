inherit image

DESCRIPTION = "WPEWebKit Webruntime Image"

IMAGE_PREINSTALL:append = " \
    acl \
    at-spi2-core \
    bash \
    bash-completion \
    bubblewrap \
    ca-certificates \
    console-setup \
    gstreamer1.0-gl \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    initramfs-tools \
    iproute2 \
    iputils-ping \
    keyboard-configuration \
    libgl1-mesa-dri \
    libpam-systemd \
    lighttpd \
    lshw \
    lsb-release \
    ntpsec \
    openssh-server \
    plymouth \
    plymouth-themes \
    polkitd \
    rtkit \
    sudo \
    systemd \
    systemd-resolved \
    vim \
    weston \
    xdg-dbus-proxy"

IMAGE_INSTALL:append = " \
    customization \
    customization-wpewebkit \
    expand-on-first-boot \
    sshd-regen-keys \
    weston-init \
    weston-webruntime-modules \
    wpewebkit"

IMAGE_PREINSTALL:append:amd64 = " gstreamer1.0-fdkaac"
IMAGE_INSTALL:append:bookworm:arm64 = " gstreamer1.0-fdkaac"

