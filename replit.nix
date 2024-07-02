{ pkgs }: {
    deps = [
      pkgs.maven
      pkgs.jre
      pkgs.openjdk
      pkgs.jetbrains.jdk
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
    ];
}