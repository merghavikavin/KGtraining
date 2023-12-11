package com.springone.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/req")
public class SampController {

    // @RequestMapping(value = "/ex/foos", headers = "key=val", method =
    // RequestMethod.POST)
    // @ResponseBody
    // public String postFoosWithHeader() {
    // return "Post some Foos with Header";
    // }

    // @RequestMapping(value = "/ex/foos", headers = { "key1=val1", "key2=val2" },
    // method = RequestMethod.GET)
    // @ResponseBody
    // public String getFoosWithHeaders() {
    // return "Get some Foos with Header";
    // }
    // @RequestMapping(value = "/ex/foos", method = RequestMethod.GET, headers =
    // "Accept=application/json")
    // @ResponseBody
    // public String getFoosAsJsonFromBrowser() {
    // return "Get some Foos with Header Old";
    // }

    // @RequestMapping(value = "/ex/foos", method = RequestMethod.GET, produces =
    // "application/json")
    // @ResponseBody
    // public String getFoosAsJsonFromREST() {
    // return "Get some Foos with Header New";
    // }
    // @RequestMapping(
    // value = "/ex/foos",
    // method = RequestMethod.GET,
    // produces = { "application/json", "application/xml" }
    // )
    // @ResponseBody
    // public String getFoos() {

    // return "Get some Foos with Header New2.0";
    // }
    // @RequestMapping(value = "/ex/foos/{id}", method = RequestMethod.GET)
    // @ResponseBody
    // public String getFoosBySimplePathWithPathVariable(
    // @PathVariable("id") long id) {
    // return "Get a specific Foo with id=" + id;
    // }

//    @RequestMapping(value = "/ex/foos/{fooid}/bar/{barid}", method = RequestMethod.GET)
// @ResponseBody
// public String getFoosBySimplePathWithPathVariables(@PathVariable("fooid") long fooid, @PathVariable("barid") long barid) {
//     return "Get a specific Bar with id=" + barid +
//             " from a Foo with id=" + fooid;

// }
@RequestMapping(value = "/ex/bars/{numericId:[\\d]+}", method = RequestMethod.GET)
@ResponseBody
public String getBarsBySimplePathWithPathVariable(
  @PathVariable("numericId") long numericId) {
    return "Get a specific Bar with id=" + numericId;
}
}
