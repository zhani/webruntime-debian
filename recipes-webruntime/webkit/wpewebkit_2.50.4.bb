inherit dpkg

S = "${WORKDIR}/wpewebkit-${PV}"
SRC_URI = "https://wpewebkit.org/releases/wpewebkit-${PV}.tar.xz;name=wpewebkit; \
    file://rules"
SRC_URI[wpewebkit.sha256sum] = "d204e405b0975508748c0273c18090304a979e1170ffa2a0a528fad90191ef87"

BINDIR = "${bindir}"

SBUILD_FLAVOR="clang"

DEPENDS += " libsoup3"
DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends}"

DEBIAN_BUILD_DEPENDS = " \
    bubblewrap, \
    cmake, \
    flite1-dev, \
    gperf, \
    libatk-bridge2.0-dev, \
    libatk1.0-dev, \
    libavif-dev, \
    libepoxy-dev, \
    libfontconfig-dev, \
    libgbm-dev, \
    libgcrypt20-dev, \
    libgstreamer-plugins-bad1.0-dev, \
    libgstreamer-plugins-base1.0-dev, \
    libgstreamer1.0-dev, \
    libharfbuzz-dev, \
    libicu-dev, \
    libinput-dev, \
    libjpeg-dev, \
    libjxl-dev, \
    libsoup-3.0-dev (>= 3.6.5), \
    libseccomp-dev, \
    libsqlite3-dev, \
    libsystemd-dev, \
    libtasn1-6-dev, \
    libwayland-dev, \
    libwebp-dev, \
    libwoff-dev, \
    libwpe-1.0-dev, \
    libwpebackend-fdo-1.0-dev, \
    libxslt1-dev, \
    ninja-build, \
    pkg-config, \
    ruby:native, \
    unifdef:native, \
    wayland-protocols, \
    xdg-dbus-proxy"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    deb_debianize
}
