package com.example.test1.appleController;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;

@RestController
public class AppleController {

    @GetMapping("/product1")
    public ResponseEntity<ObjectNode> product1(){
        ObjectNode jsonNodes = JsonNodeFactory.instance.objectNode();
        jsonNodes.put("ID", "1");
        jsonNodes.put("Name", "iPhone 15");
        jsonNodes.put("Unit Price", "1499.99");
        return new ResponseEntity<>(jsonNodes, HttpStatus.OK);
    }

    @GetMapping("/product2")
    public ResponseEntity<ObjectNode> product2(){
        ObjectNode jsonNodes = JsonNodeFactory.instance.objectNode();
        jsonNodes.put("ID", "2");
        jsonNodes.put("Name", "MacBook Pro");
        jsonNodes.put("Unit Price", "2999.99");
        return new ResponseEntity<>(jsonNodes, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<ArrayNode> usersPagination(@RequestParam("size") int size, @RequestParam("page") int page){

        int _size = size;

        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();

        ObjectNode jsonNodesProduct1 = JsonNodeFactory.instance.objectNode();
        jsonNodesProduct1.put("ID", "1");
        jsonNodesProduct1.put("Name", "iPhone 15");
        jsonNodesProduct1.put("Unit Price", "1499.99");

        ObjectNode jsonNodesProduct2 = JsonNodeFactory.instance.objectNode();
        jsonNodesProduct2.put("ID", "2");
        jsonNodesProduct2.put("Name", "MacBook Pro");
        jsonNodesProduct2.put("Unit Price", "2999.99");

        arrayNode.add(jsonNodesProduct1);
        arrayNode.add(jsonNodesProduct2);
        return new ResponseEntity<>(arrayNode, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ObjectNode> user(@PathVariable("id") Long id){
        if (id == 1){
            ObjectNode jsonNodesProduct1 = JsonNodeFactory.instance.objectNode();
            jsonNodesProduct1.put("ID", "1");
            jsonNodesProduct1.put("Name", "iPhone 15");
            jsonNodesProduct1.put("Unit Price", "1499.99");
            return new ResponseEntity<>(jsonNodesProduct1, HttpStatus.OK);
        }
        else if (id == 2) {
            ObjectNode jsonNodesProduct2 = JsonNodeFactory.instance.objectNode();
            jsonNodesProduct2.put("ID", "2");
            jsonNodesProduct2.put("Name", "MacBook Pro");
            jsonNodesProduct2.put("Unit Price", "2999.99");
            return new ResponseEntity<>(jsonNodesProduct2, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
