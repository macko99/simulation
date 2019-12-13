class Gene {

    private final int[] gene;

    Gene() {
        int[] gen = new int[32];
        for (int i = 0; i < 32; i++) {
            double randomGen = Math.random() * 7;
            gen[i] = (int) randomGen;
        }
        this.gene = GeneValidator(gen);
    }

    Gene(Gene parent1, Gene parent2) {
        int[] childGene = new int[32];
        double randomCut = Math.random() * 15;
        double randomCut2 = Math.random() * 15 + 16;
        int j = 0;
        for (int i = (int) randomCut2; i < 32; i++) {
            childGene[j++] = parent1.gene[i];
        }
        for (int i = (int) randomCut; i < (int) randomCut2; i++) {
            childGene[j++] = parent2.gene[i];
        }
        for (int i = 0; i < (int) randomCut; i++) {
            childGene[j++] = parent1.gene[i];
        }
        this.gene = GeneValidator(childGene);
    }

    private int[] GeneValidator(int[] childGene) {
        int[] model = new int[8];
        for (int i = 0; i < 32; i++) {
            model[childGene[i]]++;
        }
        for (int i = 0; i < 8; i++) {
            if (model[i] == 0) {
                double randomGene = Math.random() * 31;
                childGene[(int) randomGene] = i;
                childGene = GeneValidator(childGene);
            }
        }
        return childGene;
    }

    int[] getGene() {
        return this.gene;
    }

    int getDominantGene(){
        int dominantGene = 8;
        int dominantGeneCounter = 0;
        int[] findDominantGene = new int[8];

        for(int i=0; i<32; i++){
            findDominantGene[gene[i]]++;
        }
        for(int i=0; i<8; i++){
            if(findDominantGene[i] > dominantGeneCounter) {
                dominantGeneCounter = findDominantGene[i];
                dominantGene = i;
            }
        }
        return dominantGene;
    }

}
