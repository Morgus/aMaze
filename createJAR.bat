@echo on
cd bin
jar cmf ../Manifest.txt aMaze.jar com/amaze/*.class
move aMaze.jar ../
exit