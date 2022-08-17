var reverseString = function(s) {
    if (s.length < 2)
        return;
    let l = s.length-2;
    revString(s,l);
};

var revString = function(s,l){
    if (l===0){
        let x = s.shift();
        s.push(x);
        return;
    }
    
    let x = s.splice(l,1)[0];
    s.push(x);
    let l2 = l-1;
    revString(s,l2);
}