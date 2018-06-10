
Pod::Spec.new do |s|
  s.name         = "RNAirpush"
  s.version      = "1.0.0"
  s.summary      = "RNAirpush"
  s.description  = <<-DESC
                  Airpush support for **Android**
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "jeral17@gmail.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/jerson/react-native-airpush.git", :tag => "master" }
  s.source_files  = "RNAirpush/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  