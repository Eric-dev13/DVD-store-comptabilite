import { TestBed, waitForAsync } from '@angular/core/testing';
import { DvdComponent } from './dvd.component';
import { ActivatedRoute, convertToParamMap } from '@angular/router';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { DvdModel } from 'src/app/services/dvd-model.interface';


describe('dvdComponent', () => {
    // ARRANGE
    let component: DvdComponent;
    let route: ActivatedRoute;
    let httpTestingController: HttpTestingController;


    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [DvdComponent],
            imports: [HttpClientModule, FontAwesomeModule, HttpClientTestingModule],
            providers: [
                {
                    provide: ActivatedRoute,
                    useValue: {
                        snapshot: {
                            paramMap: convertToParamMap({ id: 1 }) // id de l'url
                        },
                    },
                },
            ]
        })
            .compileComponents();
    });
    

    beforeEach(() => {
        const fixture = TestBed.createComponent(DvdComponent);
        component = fixture.componentInstance;
    });


    // ASSERT
    it('should create', () => {
        expect(component).toBeTruthy();
    });


    it('should return "Hello World!"', () => {
        expect(component.maFonction()).toBe('Hello World!');
    });


    it('should fetch DVD by Id', async () => {
        // Object doit repecter la structure des données
        const mockDvd: DvdModel =
        {
            id: 1,
            name: "Titanic",
            genre: "",
            realisateur: "",
            acteur: "",
            quantity: 0,
            price: 0,
            filename: "",
            synopsis: ""
        }

        // Requete 
        component.findById(1);

        // Envoi une requete vers la meme url puis attends une réponse
        let req = httpTestingController.expectOne('http://localhost:9000/api/1');
        expect(req.request.method).toEqual('GET');

        // Définit la réponse attendu.
        req.flush(mockDvd);

        // Verifie que les données correspondent
        expect(component.dvd).toEqual(mockDvd);

    });

    it('should fetch DVD BY ID 2', async () => {
        // Object doit repecter la structure des données
        const mockDvd: DvdModel =
        {
            id: 1,
            name: "Titanic",
            genre: "drame",
            realisateur: "James Cameron",
            acteur: "Leonardo DiCaprio, Kate Winslet, Billy Zane",
            quantity: 100,
            price: 10,
            filename: "affiche-film-titanic.jpg",
            synopsis: "Southampton, 10 avril 1912. Le paquebot le plus grand et le plus moderne du monde, réputé pour son insubmersibilité, le Titanic, appareille pour son premier voyage. Quatre jours plus tard, il heurte un iceberg. A son bord, un artiste pauvre et une grande bourgeoise tombent amoureux. "
        }

        // Requete 
        component.findById(1);

        while (component.dvd == undefined) {
            // Faire quelque chose
        }

        expect(component.dvd).toEqual(mockDvd);

    });

});