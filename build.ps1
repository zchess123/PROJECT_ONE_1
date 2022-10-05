param(
    $rule = "default",
    $testcommand = "all"
)
<# NOTE: Update these variables to target different files with this script. #>
$MAIN = "Talk"
$TEST = "TalkTest"
<# ======================================================================== #>
if ( $rule -eq "" -or $rule -eq "default" -or $rule -eq "run" ) {
    javac -d target -cp src "src/main/java/$MAIN.java" && `
    java -cp target "main.java.$MAIN" -a
} elseif ( $rule -eq "test" ) {
    javac -d target -cp lib/junit.jar:src "src/test/java/$TEST.java" && `
    java -cp lib/junit.jar:target "test.java.$TEST" $testcommand
} elseif ( $rule -eq "fmt" ) {
    java -jar lib/google-java-format.jar --replace --skip-javadoc-formatting src/main/java/*.java src/test/java/*.java
} elseif ( $rule -eq "sync" ) {
    git fetch origin main
    git pull origin main
    git add -A
    git commit -m "Syncs changes"
    git push origin main
} elseif ( $rule -eq "submit" ) {
    git fetch origin main
    git pull origin main
    java -jar lib/google-java-format.jar --replace --skip-javadoc-formatting src/main/java/*.java src/test/java/*.java
    git add -A
    javac -d target -cp lib/junit.jar:src "src/test/java/$TEST.java" && `
    java -cp lib/junit.jar:target "test.java.$TEST" $testcommand && `
    git commit -m "Submits assignment" && `
    git push origin main
} elseif ( $rule -eq "clean" ) {
    rm -r target/*
} else {
    Write-Output "build: *** No rule to make target '$rule'.  Stop."
}
