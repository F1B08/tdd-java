# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/trusty64"
 
  config.vm.network "forwarded_port", guest: 27017, host: 27017

  config.vm.provider "virtualbox" do |vb|
    vb.gui = true
    vb.memory = "1024"
  end

  config.vm.provision "docker" do |d|
    d.run "mongoDB", image: "mongo:2", args: "-p 27017:27017"
  end

end