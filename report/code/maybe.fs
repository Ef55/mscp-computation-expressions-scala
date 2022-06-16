type MaybeBuilder() =
  // Gives meaning to let!
  member x.Bind(opt, f) = Option.bind f opt
  // Gives meaning to return
  member x.Return(v) = Some(v)
    
let maybe = new MaybeBuilder() 

let m = maybe{
  let! v = Some(0)
  return v + 1
}
// m == Some(1)