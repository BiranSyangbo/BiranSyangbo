#!/usr/bin/zsh

set -e

generate_api() {
  module=$1
  openapi-generator-cli batch codegen/${module}-server.yaml
}

m="user"
generate_api ${m}