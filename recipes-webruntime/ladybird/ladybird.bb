inherit dpkg

SRC_URI = "git://github.com/LadybirdBrowser/ladybird.git;protocol=https;branch=master; \
    file://0001-Downgrade-icu-version-requirement.patch \
    file://0002-Support-OpenSSL-3.2.patch \
    file://0003-Build-Lagom-tools-when-cross-compiling.patch \
    file://0004-Hack-frameless-Qt-BrowserWindow.patch \
    file://0005-Meta-CMake-Do-not-use-march-native-when-cross-compil.patch \
    file://rules"

SRC_URI:append:bookworm = " \
    file://0006-Revert-ML-DSA.patch \
    file://0007-Support-libxml2-2.12.patch"

SRCREV = "b65b8c2e6ab81798ea6a43e11ac62f6e06bf6525"

S = "${WORKDIR}/git"

SBUILD_FLAVOR="clang"

DEPENDS = "angle simdutf skia"

DEBIAN_DEPENDS =. " \
    libangle, \
    libavif16, \
    libskia, \
    libtommath1, \
    simdutf, \
    qt6-wayland, \
    \${shlibs:Depends}, \
    \${misc:Depends}"

DEBIAN_BUILD_DEPENDS = " \
    cmake, \
    fonts-liberation2, \
    libangle-dev, \
    libavcodec-dev, \
    libavformat-dev, \
    libavif-dev, \
    libcurl4-openssl-dev, \
    libdrm-dev, \
    libfast-float-dev, \
    libfontconfig-dev, \
    libgl1-mesa-dev, \
    libharfbuzz-dev, \
    libicu-dev, \
    libjpeg-dev, \
    libjxl-dev, \
    libpng-dev, \
    libpulse-dev, \
    libsdl3-dev, \
    libskia-dev, \
    libssl-dev, \
    libsqlite3-dev, \
    libtommath-dev, \
    libwebp-dev, \
    libwoff-dev, \
    libxkbcommon-dev, \
    libxml2-dev, \
    nasm, \
    ninja-build, \
    pkg-config, \
    qt6-base-dev, \
    qt6-tools-dev-tools, \
    simdutf-dev"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    deb_debianize
}
