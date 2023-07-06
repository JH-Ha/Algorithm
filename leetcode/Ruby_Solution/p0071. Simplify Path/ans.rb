# @param {String} path
# @return {String}
def simplify_path(path)
    names = path.split('/',-1)
    .select{|name| name.length > 0 && name != "."}
#    puts "#{names}"
    ans = []
    for i in 0..names.length-1 do
        if(names[i] == "..")
            ans.pop()
        else
            ans.append(names[i])
        end
    end
    return "/#{ans.join("/")}"
end

#simplify_path("/home//foo/")
#simplify_path("/home/.././foo/")
# puts "#{simplify_path("/a/./b/../../c/")}"