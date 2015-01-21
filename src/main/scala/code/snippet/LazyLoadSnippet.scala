package code.snippet


import net.liftweb.http.IdMemoizeTransform
import net.liftweb.util.PassThru
import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml._
import net.liftweb.util.StringHelpers

class LazyLoadSnippet {
  
  var idMem: IdMemoizeTransform = null

  def data = {
    Thread.sleep(3000)
    ".data *" #> StringHelpers.randomString(8)
  }
  
  def render = {
    "#reset" #> ajaxButton("reset idMem (press again and again faster than it can lazy load)", () => {
      idMem.setHtml()
    }) &
    "#idMem" #> idMemoize(func => {
      idMem = func
      PassThru
    })
  }
  
}