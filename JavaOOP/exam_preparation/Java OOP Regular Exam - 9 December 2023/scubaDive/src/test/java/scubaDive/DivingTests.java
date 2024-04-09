


    @Test
    public void removeMethod_ShouldReturnTrueIfDiverIsFound() {
        Diving ontario = new Diving("Ontario" , 2);
        ontario.addDeepWaterDiver(diver);

        boolean isRemove = ontario.removeDeepWaterDiver("Elijah");

        Assert.assertTrue(isRemove);
    }
